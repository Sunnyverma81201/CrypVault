package com.apoorv.crypvault

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.*

class VaultListAdapter(private val context:Activity, private val vaultNameArray: Array<String> ):ArrayAdapter<String>(context,R.layout.vault_list_view,vaultNameArray) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.vault_list_view,null,true)

        val vaultName:TextView? = rowView.findViewById(R.id.Vault_name_from_list)
        vaultName?.text = vaultNameArray[position]

        return rowView
    }
}