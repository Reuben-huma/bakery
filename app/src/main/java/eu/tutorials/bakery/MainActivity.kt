package eu.tutorials.bakery

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {R.id.shareMenuButton -> onShare() }
        return super.onOptionsItemSelected(item)
    }

    private fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setSubject(getString(R.string.share_subject))
            .setText(getString(R.string.share_text, 5, "27"))
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        }
        catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, getString(R.string.sharing_not_available), Toast.LENGTH_LONG).show()
        }
    }
}