package com.example.sidedrawerapplication.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sidedrawerapplication.R
import com.example.sidedrawerapplication.data.model.person.Person
import com.example.sidedrawerapplication.data.model.person.PersonItem
import com.example.sidedrawerapplication.databinding.ItemPersonBinding

class PeopleAdapter(val data: Person) :
    RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {
    inner class ViewHolder(
        val view: ItemPersonBinding
    ) : RecyclerView.ViewHolder(view.root) {
        fun initUI(personItem: PersonItem) {
            val context = itemView.context
            view.apply {
                Glide.with(context)
                    .load(personItem.avatar)
                    .placeholder(R.drawable.animate_loading)
                    .centerCrop()
                    .into(ivProfileAvatar)
                tvName.text = context.getString(
                    R.string.person_name,
                    personItem.firstName,
                    personItem.lastName
                )
                tvEmail.text = context.getString(R.string.person_email, personItem.email)
                tvWork.text =
                    context.getString(R.string.person_jobTitle, personItem.employment?.title)
                tvPhoneNumber.text = context.getString(
                    R.string.person_phone_number,
                    personItem.phoneNumber
                )

                tvGender.text = context.getString(R.string.gender, personItem.gender)
                tvBerthDate.text = context.getString(R.string.berth_date, personItem.dateOfBirth)
                tvSkill.text =
                    context.getString(R.string.key_skill, personItem.employment?.keySkill)
                tvAddress.text = context.getString(
                    R.string.address,
                    personItem.address?.streetAddress,
                    personItem.address?.streetName,
                    personItem.address?.city,
                    personItem.address?.state,
                    personItem.address?.country,
                    personItem.address?.zipCode
                )

                ivArrow.setOnClickListener {
                    if (detailLayout.visibility == View.VISIBLE) {
                        detailLayout.visibility = View.GONE
                        ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
                    } else {
                        detailLayout.visibility = View.VISIBLE
                        ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
                    }
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.initUI(data[position])

    override fun getItemCount() = data.size
}
