package com.example.recylerview;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URI;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private List<ModalClass> modalClassList;

    public Adapter(List<ModalClass> modalClassList) {
        this.modalClassList = modalClassList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        String profilePicUrl = modalClassList.get(position).getProfileUrl();
        String name = modalClassList.get(position).getName();
        String city = modalClassList.get(position).getCity();
        String uploadDay = modalClassList.get(position).getDayUploaded();
        String postDesc = modalClassList.get(position).getPostDescription();
        String postimgUrl=modalClassList.get(position).getPostImgUrl();
        int totalLike=modalClassList.get(position).getTotalLike();
        int totalComment=modalClassList.get(position).getTotalComment();

        viewholder.setData(profilePicUrl,name,city,uploadDay,postDesc,postimgUrl,totalLike,totalComment);
    }

    @Override
    public int getItemCount() {
        return modalClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private SimpleDraweeView uploaderprofilepic,uploadedPostImage;
        private TextView uploaderName,uploaderCity,uploadedDay,uploadedPostDesciption,totalLikes,totalComments;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            uploaderprofilepic=itemView.findViewById(R.id.card_view_post_user_profile);
            uploadedPostImage=itemView.findViewById(R.id.card_view_post_img);
            uploaderName=itemView.findViewById(R.id.card_view_post_user_name);
            uploaderCity=itemView.findViewById(R.id.card_view_post_city);
            uploadedDay=itemView.findViewById(R.id.card_view_post_day_before);
            uploadedPostDesciption=itemView.findViewById(R.id.card_view_post_description);
            totalLikes=itemView.findViewById(R.id.card_view_post_total_likes);
            totalComments=itemView.findViewById(R.id.card_view_post_total_comments);
        }

        private void setData(String profileUrl, String name, String city, String dayUploaded, String postDescription, String postImgUrl, int totalLike, int totalComment){
            Uri uriprofile= Uri.parse(profileUrl);
            uploaderprofilepic.setImageURI(uriprofile);
            Uri uripostimg=Uri.parse(postImgUrl);
            uploadedPostImage.setImageURI(uripostimg);
            uploaderName.setText(name);
            uploaderCity.setText(city);
            uploadedDay.setText(dayUploaded);
            uploadedPostDesciption.setText(postDescription);
            totalLikes.setText(String.valueOf(totalLike));
            totalComments.setText(String.valueOf(totalComment));

        }
    }
}
