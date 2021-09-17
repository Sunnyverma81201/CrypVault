package com.apoorv.crypvault

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private val data = arrayOf("Pins","Password","Files")

    private fun toggleBottomSheet(){
        val bottomSheetToggleButton: ImageButton = findViewById(R.id.expand_bottom_sheet_button)
        val bottomSheet: LinearLayout  = findViewById(R.id.bottom_sheet)
        val bottomSheetBehavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottomSheet)

        if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED){
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            bottomSheetToggleButton.rotation = bottomSheetToggleButton.rotation - 180
        }else if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED){
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetToggleButton.rotation = bottomSheetToggleButton.rotation + 180
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomSheetToggleButton: ImageButton = findViewById(R.id.expand_bottom_sheet_button)
        val vaultListView: ListView = findViewById(R.id.vault_list)
        val noVaultAddButton:ImageButton = findViewById(R.id.no_vault_add_button)
        val vaultListAdapter:VaultListAdapter = VaultListAdapter(this,data)
        val emptyListTextView:TextView = findViewById(R.id.empty_list_indicator)

//        if(vaultListView.adapter.count==0){
//            noVaultAddButton.visibility = View.VISIBLE
//        }
        vaultListView.adapter = vaultListAdapter
        if (vaultListView.count == 0){
            noVaultAddButton.visibility = View.VISIBLE
            emptyListTextView.visibility = View.VISIBLE
        }

        noVaultAddButton.setOnClickListener {
            Log.i(Log.INFO.toString(),"BottomSheet Toggled")
            toggleBottomSheet()
        }
        bottomSheetToggleButton.setOnClickListener {
            Log.i(Log.INFO.toString(),"BottomSheet Toggled")
            toggleBottomSheet()
        }
    }
}
