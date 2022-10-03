package garipolesya.com.example.emoji

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aghajari.emojiview.AXEmojiManager
import com.aghajari.emojiview.googleprovider.AXGoogleEmojiProvider
import com.aghajari.emojiview.view.AXEmojiView
import garipolesya.com.example.emoji.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        AXEmojiManager.install(this, AXGoogleEmojiProvider(this))
        val emojiView = AXEmojiView(this)
        emojiView.editText = binding.chatInput
        binding.layout.initPopupView(emojiView)

        binding.buttonEmoticon.setOnClickListener {
            if (binding.layout.isShowing) {
                binding.layout.hideAndOpenKeyboard()
            } else {
                binding.layout.toggle()
            }
        }

    }
}