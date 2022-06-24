package com.example.tbc_homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import com.example.tbc_homework_3.databinding.ActivityMainBinding

private  fun isValidEmail(email: String):Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

private  fun isValidUsername(username: String):Boolean {
    if (username.length<10)  return false
     return true

}

private  fun isValidAge(age: String):Boolean {
    if(age.toDoubleOrNull() == null) return false
    val ageAsDouble=age.toDouble()
    if (ageAsDouble.toInt().toDouble() != ageAsDouble  || age.toInt()<1 )  return false

    return true

}


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener  {
            var email = binding.editTextPersonEmailAddress.text.toString()
            var age = binding.editTextAge.text.toString()
            var username = binding.editTextPersonUsername.text.toString()
            var firstName = binding.editTextPersonFirstName.text.toString()
            var lastName = binding.editTextPersonLastName.text.toString()

                if(email.isEmpty() || age.isEmpty() || username.isEmpty() || firstName.isEmpty() || lastName.isEmpty())
                    binding.errorEmptyField.setVisibility(VISIBLE)
                else {
                    binding.errorEmptyField.setVisibility(INVISIBLE)

                    if (!isValidEmail(email))
                        binding.errorEmail.text = "Email is not valid"
                    else binding.errorEmail.text =""

                    if (!isValidAge(age))
                        binding.errorAge.text = "Age should be positive whole number"
                    else binding.errorAge.text =""
                        if (!isValidUsername(username))
                        binding.errorUsername.text = "Username must contain at least 10 characters"
                    else binding.errorUsername.text
                }
            /*
In the US there are approximately 1548 people male and female named 7
so person names can be just numbers as well
*/
        }
        binding.buttonClear.setOnLongClickListener  {
            binding.editTextPersonEmailAddress.setText("")
            binding.editTextAge.setText("")
            binding.editTextPersonUsername.setText("")
            binding.editTextPersonFirstName.setText("")
            binding.editTextPersonLastName.setText("")
            true

        }

    }
}