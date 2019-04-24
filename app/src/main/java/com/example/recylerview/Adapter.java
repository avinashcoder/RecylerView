package com.example.recylerview;

import android.content.Context;
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
    private Context mContext;
    private List<ModalClass> modalClassList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public Adapter(Context context, List<ModalClass> modalClassList) {
        mContext = context;
        this.modalClassList = modalClassList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout,viewGroup,false);
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }

        private void setData(String profileUrl, String name, String city, String dayUploaded, String postDescription, String postImgUrl, int totalLike, int totalComment){
            if(profileUrl.equals("default")) {
                uploaderprofilepic.setImageResource(R.drawable.ic_launcher_foreground);
            }
            else {
                Uri uriprofile= Uri.parse(profileUrl);
                uploaderprofilepic.setImageURI(uriprofile);
            }

            if(postImgUrl.equals("default")) {
                uploadedPostImage.setVisibility(View.GONE);
            }
            else {
                Uri uripostimg = Uri.parse(postImgUrl);
                uploadedPostImage.setImageURI(uripostimg);
            }
            uploaderName.setText(name);
            uploaderCity.setText(city);
            uploadedDay.setText(dayUploaded);
            if(postDescription.equals("default")) {
                uploadedPostDesciption.setVisibility(View.GONE);
            }
            else {
                uploadedPostDesciption.setText(postDescription);
            }

            totalLikes.setText(String.valueOf(totalLike));
            totalComments.setText(String.valueOf(totalComment));

        }
    }
}
