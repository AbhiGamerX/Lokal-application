package project.assignment.lokal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClickListener
{
    lateinit var pressButton: Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage_layout)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.app_actionbar_layout)

        pressButton = findViewById(R.id.welcomeButton)
        pressButton.setOnClickListener(this)
    }

    override fun onClick(v: View?)
    {
        intent = Intent(this, ProductViewActivity::class.java)
        startActivity(intent)
    }
}
