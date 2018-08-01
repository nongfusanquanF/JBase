package com.appbyme.jbase;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appbyme.jbase.databinding.ActivityListFragmentBinding;
import com.appbyme.jbase.databinding.ActivityMainBinding;
import com.appbyme.jbase.ui.DetailsActivity;
import com.appbyme.jbase.ui.FragmentListActivity;
import com.appbyme.jbase.ui.FragmentObjActivity;
import com.appbyme.jbase.ui.ListActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mBinding.setOnclick(new UiClick());
    }


    public class UiClick {

        public void uiClick(View v) {

            switch (v.getId()) {
                case R.id.list_activity:
                    startActivity(new Intent(MainActivity.this, ListActivity.class));
                    break;

                case R.id.list_fragment:
                    startActivity(new Intent(MainActivity.this, FragmentListActivity.class));
                    break;

                case R.id.details_activity:
                    startActivity(new Intent(MainActivity.this, DetailsActivity.class));
                    break;

                case R.id.details_fragment:
                    startActivity(new Intent(MainActivity.this, FragmentObjActivity.class));
                    break;

            }
        }

    }

}
