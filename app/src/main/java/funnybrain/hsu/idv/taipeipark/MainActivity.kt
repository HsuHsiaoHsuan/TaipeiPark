package funnybrain.hsu.idv.taipeipark

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import funnybrain.hsu.idv.taipeipark.restful.model.Park
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), ParkContract.View {

    private val scope = "resourceAquire"
    private val rid = "bf073841-c734-49bf-a97f-3757a6013812"
    private var parkAdapter: ParkAdapter? = null
    private val dataList = ArrayList<Park>()

    private var mPresenter: ParkContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = ParkPresenter(ParkRepository.getInstance(scope, rid), this)

        parkAdapter = ParkAdapter(this, dataList)
        list.setHasFixedSize(true)
        list.adapter = parkAdapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onResume() {
        super.onResume()
        mPresenter!!.loadTask(true)
    }

    override fun setPresenter(presenter: ParkContract.Presenter) {
        mPresenter = presenter
    }

    override fun showProgress(show: Boolean) {
    }

    override fun showPark(parks: List<Park>) {
        dataList.clear()
        dataList.addAll(parks)
        parkAdapter!!.notifyDataSetChanged()
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
