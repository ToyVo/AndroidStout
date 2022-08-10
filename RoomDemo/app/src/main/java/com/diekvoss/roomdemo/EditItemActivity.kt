package com.diekvoss.roomdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new.*

class EditItemActivity : AppCompatActivity() {

    var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            id = bundle.getString(ExampleListAdapter.ID)
            val book = bundle.getString(ExampleListAdapter.BOOK)
            val author = bundle.getString(ExampleListAdapter.AUTHOR)
            val description = bundle.getString(ExampleListAdapter.DESCRIPTION)
            val lastUpdated = bundle.getString(ExampleListAdapter.LAST_UPDATED)

            etAuthorName.setText(author)
            etBookName.setText(book)
            etDescription.setText(description)
            txvLastUpdated.text = lastUpdated
        }

        bSave.setOnClickListener {
            val updatedAuthor = etAuthorName.text.toString()
            val updatedBook = etBookName.text.toString()
            val updatedDescription = etDescription.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra(ID, id)
            resultIntent.putExtra(UPDATED_AUTHOR, updatedAuthor)
            resultIntent.putExtra(UPDATED_BOOK, updatedBook)
            resultIntent.putExtra(UPDATED_DESCRIPTION, updatedDescription)
            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }

        bCancel.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val ID = "book_id"
        const val UPDATED_AUTHOR = "author_name"
        const val UPDATED_BOOK = "book_name"
        const val UPDATED_DESCRIPTION = "description"
    }
}
