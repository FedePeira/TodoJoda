import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.myapplication.R

fun AppCompatButton.setHoverEffect() {
    this.setOnHoverListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_HOVER_ENTER -> {
                // Cambia la apariencia del botón cuando el mouse entra (pasa sobre el botón)
                this.background = ContextCompat.getDrawable(this.context, R.drawable.button_hovered_background)
            }
            MotionEvent.ACTION_HOVER_EXIT -> {
                // Cambia la apariencia del botón cuando el mouse sale (deja de pasar sobre el botón)
                this.background = ContextCompat.getDrawable(this.context, R.drawable.button_default_background)
            }
        }
        false
    }
}


