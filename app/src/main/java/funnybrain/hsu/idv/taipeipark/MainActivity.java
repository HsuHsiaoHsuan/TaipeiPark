package funnybrain.hsu.idv.taipeipark;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import funnybrain.hsu.idv.taipeipark.restful.model.Park;

public class MainActivity extends AppCompatActivity implements ParkContract.View {
    private static final String TAG = "MainActivity";

    @BindView(R.id.list) RecyclerView recyclerView;

    private String scope = "resourceAquire";
    private String rid = "bf073841-c734-49bf-a97f-3757a6013812";
    private ParkAdapter parkAdapter;
    private List<Park> dataList = new ArrayList<>();

    private ParkContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new ParkPresenter(ParkRepository.Companion.getInstance(scope, rid), this);

        parkAdapter = new ParkAdapter(this, dataList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(parkAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadTask(true);
    }

    @Override
    public void setPresenter(ParkContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showPark(List<Park> parks) {
        Log.d(TAG, ">>>>> " + parks.size());
        dataList.clear();
        dataList.addAll(parks);
        parkAdapter.notifyDataSetChanged();
    }
}
