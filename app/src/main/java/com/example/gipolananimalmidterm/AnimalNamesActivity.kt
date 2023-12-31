package com.example.gipolananimalmidterm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Button

class AnimalNamesActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_names)

        // Get a reference to the ListView
        val nameListView: ListView = findViewById(R.id.nameListView)

        // Define a list of animal names
        val animalNames = arrayOf("Antilope", "Bear", "Cat", "Dog", "Elephant", "Fox", "Grasshopper")

        // To display the animal names
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, animalNames)

        // Set the adapter for the ListView
        nameListView.adapter = adapter

        // Set an OnItemClickListener for the ListView
        nameListView.setOnItemClickListener { _, _, position, _ ->
            // Get the selected animal name
            val selectedAnimalName = animalNames[position]

            // Redirect to AnimalDetailsActivity with the selected animal name
            val intent = Intent(this, AnimalDetailsActivity::class.java)
            intent.putExtra("animalName", selectedAnimalName)
            startActivity(intent)
        }

        // Get a reference to the "Manage Block Animals" button
        val manageBlockAnimalsButton: Button = findViewById(R.id.manageBlockAnimalsButton)

        // Set a click listener for the button
        manageBlockAnimalsButton.setOnClickListener {
            // Redirect to the ActivityManageBlock
            val intent = Intent(this, ManageBlockActivity::class.java)
            startActivity(intent)
        }
    }
}
