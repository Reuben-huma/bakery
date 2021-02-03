package eu.tutorials.bakery

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import eu.tutorials.bakery.model.BakeryViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: BakeryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Menu methods
     */
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
            .setText(getString(R.string.share_text, viewModel.dessertSold.value, viewModel.total.value))
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG).show()
        }
    }
}