package com.yjtc.cbg.yjsapp.View;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.bean.XmlParserHandler;
import com.yjtc.cbg.yjsapp.bean.model.CityModel;
import com.yjtc.cbg.yjsapp.bean.model.DistrictModel;
import com.yjtc.cbg.yjsapp.bean.model.ProvinceModel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by chenboge on 16/5/3.
 */
public class TestActivity extends AppCompatActivity {

    private TextView mAddressText;

    private OptionsPickerView mCityPikerView;

    private List<ProvinceModel> mProvinces=new ArrayList<>();
    private ArrayList<ArrayList<String>> mCities = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<ArrayList<String>>> mDistricts = new ArrayList<ArrayList<ArrayList<String>>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        mAddressText = (TextView) findViewById(R.id.tvTime);
        init();
        mAddressText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCityPikerView.show();
            }
        });
    }



    private void init() {

        initProvinceDatas();

        mCityPikerView = new OptionsPickerView(this);

        mCityPikerView.setPicker( (ArrayList) mProvinces, mCities, mDistricts, true);
        mCityPikerView.setTitle("选择城市");
        mCityPikerView.setCyclic(false,true,true);
        mCityPikerView.setSelectOptions(1,0,0);
        mCityPikerView.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {

                String addresss = mProvinces.get(options1).getName() + "  "
                        + mCities.get(options1).get(option2) + "  "
                        + mDistricts.get(options1).get(option2).get(options3);
                mAddressText.setText(addresss);
            }
        });


    }



    protected void initProvinceDatas() {

        AssetManager asset = getAssets();
        try {
            InputStream input = asset.open("province_data.xml");
            // 创建一个解析xml的工厂对象
            SAXParserFactory spf = SAXParserFactory.newInstance();
            // 解析xml
            SAXParser parser = spf.newSAXParser();
            XmlParserHandler handler = new XmlParserHandler();
            parser.parse(input, handler);
            input.close();
            // 获取解析出来的数据
            mProvinces = handler.getDataList();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {

        }
        if (mProvinces != null) {

            for (ProvinceModel p : mProvinces) {

                List<CityModel> cities = p.getCityList();
                ArrayList<String> cityStrs = new ArrayList<>(cities.size()); //城市List


                for (CityModel c : cities) {

                    cityStrs.add(c.getName()); // 把城市名称放入 cityStrs


                    ArrayList<ArrayList<String>> dts = new ArrayList<>(); // 地区 List

                    List<DistrictModel> districts = c.getDistrictList();
                    ArrayList<String> districtStrs = new ArrayList<>(districts.size());

                    for (DistrictModel d : districts) {
                        districtStrs.add(d.getName()); // 把城市名称放入 districtStrs
                    }
                    dts.add(districtStrs);


                    mDistricts.add(dts);
                }

                mCities.add(cityStrs); // 组装城市数据

            }
        }
    }

}
