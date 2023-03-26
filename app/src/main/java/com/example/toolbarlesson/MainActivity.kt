package com.example.toolbarlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.toolbarlesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private var previousSizeTextList = arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Admin"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
            R.id.save -> {
                binding.apply {
                    var textField = fieldText.text.toString()
                    val editTask = editTask.text.toString()
                    fieldText.text = "$textField \n $editTask"
                    previousSizeTextList.add(textField.count())
                }
                Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show()
            }
            R.id.delete -> {
                binding.apply {
                    val textField = fieldText.text.toString()
                    var lastElementList = previousSizeTextList.size - 1
                    var textFieldDeleteLastTask =  textField.removeRange(previousSizeTextList.get(lastElementList),
                        textField.length)
                    fieldText.text = textFieldDeleteLastTask
                    previousSizeTextList.removeAt(lastElementList)
                }
            }
        }
        return true
    }
}