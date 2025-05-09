package com.example.dailybook

import android.os.Bundle
import android.widget.TextView
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailybook.ui.theme.DailyBookTheme

class MainActivity : ComponentActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var tvAuthor: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecommend: ImageButton

    private val bookList=listOf(
        Book("달러구트 꿈 백화점", "이미예", "꿈을 파는 백화점 이야기"),
        Book("아몬드", "손원평", "감정을 모르는 소년의 성장 이야기"),
        Book("미드나잇 라이브러리", "매트 헤이그", "인생의 선택지를 다시 돌아보는 이야기"),
        Book("마음", "나쓰메 소세키", "백 년이 지난 지금 우리의 이야기")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTitle=findViewById(R.id.tvTitle)
        tvAuthor=findViewById(R.id.tvAuthor)
        tvDescription=findViewById(R.id.tvDescription)
        btnRecommend=findViewById(R.id.imageButton)

        btnRecommend.setOnClickListener{
            val randomBook=bookList.random()
            tvTitle.text=randomBook.title
            tvAuthor.text="저자: ${randomBook.author}"
            tvDescription.text="내용: ${randomBook.description}"
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DailyBookTheme {
        Greeting("Android")
    }
}


data class Book(
    val title: String,
    val author: String,
    val description: String
)