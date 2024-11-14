package br.com.safe.pass.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.safe.pass.theme.Theme
import br.com.safe.pass.ui.GeneratePasswordScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Theme {
                    GeneratePasswordScreen()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainActivityPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Theme {
            GeneratePasswordScreen()
        }
    }
}
