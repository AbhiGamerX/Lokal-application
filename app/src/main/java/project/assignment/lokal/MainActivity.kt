package project.assignment.lokal

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClickListener
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage_layout)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.app_actionbar_layout)
        //
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}
