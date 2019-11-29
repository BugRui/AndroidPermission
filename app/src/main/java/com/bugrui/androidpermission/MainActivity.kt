package com.bugrui.androidpermission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.bugrui.permission.OnPermissionsTaskListener
import com.bugrui.permission.permissionCheck

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * 相机
     */
    private val cameraTask = arrayOf("android.permission.CAMERA")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            permissionCheck(cameraTask, object : OnPermissionsTaskListener() {
                override fun onPermissionsTask() {
                    toast("权限申请通过")
                }

                override fun onDenied() {
                    toast("权限被拒绝")
                }

                override fun onNeverAskAgain() {
                    toast("权限被拒绝,并勾选不再提示")
                }
            })
        }
    }

    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
