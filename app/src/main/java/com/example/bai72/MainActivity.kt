package com.example.bai72

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private lateinit var editSearch: EditText
    private val allStudents = listOf(
        Student("Nguyen Van An", "20210001"),
        Student("Le Thi Bich", "20210002"),
        Student("Tran Minh Chau", "20210003"),
        Student("Phan Tuan Khang", "20210004"),
        Student("Hoang Ngoc Minh", "20210005"),
        Student("Vo Thi Lan", "20210006"),
        Student("Nguyen Thanh Phat", "20210007"),
        Student("Pham Van Son", "20210008"),
        Student("Bui Quang Hieu", "20210009"),
        Student("Doan Thi Kim", "20210010"),
        Student("Tran Van Bao", "20210011"),
        Student("Nguyen Quoc Anh", "20210012"),
        Student("Dinh Thi My", "20210013"),
        Student("Le Quang Huy", "20210014"),
        Student("Phan Thi Thanh", "20210015"),
        Student("Vu Tuan Linh", "20210016"),
        Student("Ngo Minh Tam", "20210017"),
        Student("Nguyen Hoang Giang", "20210018"),
        Student("Do Thi Hue", "20210019"),
        Student("Le Thanh Tung", "20210020")
    )
    private var filteredStudents = allStudents

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        adapter = StudentAdapter(filteredStudents)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Initialize search EditText
        editSearch = findViewById(R.id.edit_search)
        editSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterList(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun filterList(query: String) {
        filteredStudents = if (query.length > 2) {
            allStudents.filter {
                it.name.contains(query, ignoreCase = true) || it.mssv.contains(query, ignoreCase = true)
            }
        } else {
            allStudents
        }
        adapter.updateData(filteredStudents)
    }
}
