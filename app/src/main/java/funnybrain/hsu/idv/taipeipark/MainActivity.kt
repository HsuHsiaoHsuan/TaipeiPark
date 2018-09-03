package funnybrain.hsu.idv.taipeipark

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import funnybrain.hsu.idv.taipeipark.restful.model.Park
import org.jetbrains.anko.setContentView
import java.util.*

class MainActivity : AppCompatActivity(), ParkContract.View {

    private val scope = "resourceAquire"
    private val rid = "bf073841-c734-49bf-a97f-3757a6013812"
    private var parkAdapter: ParkAdapter? = null
    private val dataList = ArrayList<Park>()

    private var mPresenter: ParkContract.Presenter? = null

    lateinit var mainUi: MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainUi = MainActivityUi()
        mainUi.setContentView(this)

        parkAdapter = ParkAdapter(dataList)
        mainUi.list.adapter = parkAdapter

        mPresenter = ParkPresenter(ParkRepository.getInstance(scope, rid), this)
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
