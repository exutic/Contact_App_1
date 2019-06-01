package com.example.contact_app_1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.contact_app_1.Contacts;
import com.example.contact_app_1.DataBase;
import com.example.contact_app_1.R;
import java.util.List;

class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private List<Contacts> contactParentsList;
    private Context mContext;


    public ContactAdapter(List<Contacts> contactParentsList, Context mContext )
    {
        this.contactParentsList = contactParentsList;
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position)
    {
        return contactParentsList.get(position).getCurrentType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (viewType == Contacts.WITH_TEXT)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_row_build, parent, false);
            return new MovieTextViewHolder(view);
        }
//        else if (viewType == Contacts.WITH_IMAGE)
//        {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_image_list_row, parent, false);
//            return new MovieImageViewHolder(view);
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof MovieTextViewHolder)
        {
            MovieTextViewHolder viewHolder = (MovieTextViewHolder) holder;
            Contacts contactsTEST = (Contacts)contactParentsList.get ( position );

            viewHolder.txtName.setText(contactsTEST.getName());
            viewHolder.txtAddress.setText(contactsTEST.getAddress());
            viewHolder.txtMobile.setText(contactsTEST.getPhoneNumber());
        }
//        else if (holder instanceof MovieImageViewHolder)
//        {
//            MovieImageViewHolder viewHolder = (MovieImageViewHolder) holder;
//            MovieImage movieImage = (MovieImage) movies.get ( position );
//
//            viewHolder.imgMoviePic.setImageResource(movieImage.getResId());
//        }
    }

    @Override
    public int getItemCount()
    {
        return contactParentsList.size();
    }

    public class MovieTextViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtName;
        public TextView txtAddress;
        public TextView txtMobile;
        public MovieTextViewHolder(View itemView)
        {
            super(itemView);
            txtName = (TextView) itemView.findViewById ( R.id.txtName );
            txtAddress = (TextView) itemView.findViewById(R.id.txtAddress);
            txtMobile = (TextView) itemView.findViewById(R.id.txtMobile);
        }
    }

    public class MovieImageViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imgMoviePic;
        public MovieImageViewHolder(View itemView)
        {
            super(itemView);
            imgMoviePic = (ImageView) itemView.findViewById(R.id.imgMoviePic);
        }
    }
}
