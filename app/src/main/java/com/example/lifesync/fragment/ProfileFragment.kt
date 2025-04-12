package com.example.lifesync.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.compose.AsyncImage
import com.example.lifesync.R
import com.example.lifesync.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x0ff, heightDp = 800)
@Composable
fun ProfileScreen(){
    val name = "Kshitij Gujar"
    Text(
        text = "Profile",
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.white)
    )
    Column(
        modifier = Modifier.fillMaxWidth(), // Or any desired height
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally // Optional: for horizontal centering
    ) {
        AsyncImage(
            model = "https://preview.keenthemes.com/metronic-v4/theme/assets/pages/media/profile/people19.png",
            contentDescription = "Profile Image",
            modifier = Modifier.padding(3.dp).size(300.dp).clip(CircleShape),
            placeholder = painterResource(R.drawable.ic_profile)
        )
        Text(
            text =" $name ",
            modifier = Modifier.padding(3.dp),
            color = colorResource(id = R.color.white)
        )
    }

}