package com.kwon.ucf.notice_board;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kwon.ucf.R;
import com.kwon.ucf.application.ApplicationController;
import com.kwon.ucf.network.NetworkService;
import com.kwon.ucf.network.RetrofitClass;

import junit.framework.Test;

import org.json.JSONArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


//게시판
@SuppressLint("ValidFragment")
public class Fragment2 extends Fragment {

    private NetworkService mRetro = new RetrofitClass().getRetroService();
    NetworkService service; /////////////////
    ArrayList<CommentData> cData;/////////////// 이게 커먼데이터가 아니라 메뉴데이터로 되있었짢아 ㅎㅡㅓㄹ...

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View v = this.getView();
        ListView listView = (ListView) v.findViewById(R.id.listView);
        initCommentDataset();


        ArrayList<String[]> data = new ArrayList();
        for(int i = 1 ; i < 13 ; i ++) { //이부분이 서버에서 데이터 받아서 넣는부분 // 그렇다면 서버에 있는 데이터 갯수는 어떻게 세는지?
            data.add(new String[] {"text"+i,"2018/06/0"+1+i}); // ㅇㅋ?ㅇㅋ?ㅇㅋ?  //여기서 넣을때 알아서 정렬하고 넣으셈 넵 ///// 여기서 c데이터 어레이를 넣어야함!
        }
        boardAdapter adapter = new boardAdapter(data);
        listView.setAdapter(adapter);

        //리스트뷰 생성


        //
        final EditText txt_commemt;
        final Button  send_comment;

        txt_commemt = (EditText) v.findViewById(R.id.txt_comment);
        send_comment = (Button) v.findViewById(R.id.send_comment);



        send_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String comment = txt_commemt.getText().toString(); //  보낼 string 정의

                mRetro.sendComment(comment).enqueue(new Callback<JsonArray>() {
                    @Override
                    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                        if(response.code() == 200) {
                            JsonArray json = response.body(); //

                        }
                    }

                    @Override
                    public void onFailure(Call<JsonArray> call, Throwable t) {

                    }
                });

            }

        });
    }

    public interface ServerPost{
        @FormUrlEncoded
        @POST("/board")
        Call<JSONArray> sendComment(@Field("txt_comment") String getComment);
    }

    // post로 comment 보내기 기능




    ////////////////

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCommentDataset();
    }

    private void initCommentDataset(){ //initDataset 참조한것. mData->cData로 바꿔서 했음. MenuData 참조하여 CommentData 클래스 만듦
        cData = new ArrayList<>();

        service = ApplicationController.getInstance().getNetworkService();
        service.getComment().enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if(response.code()==200){
                    JsonArray arr = response.body();
                    for(int i = 0; i<arr.size(); i++){
                        JsonObject item = arr.get(i).getAsJsonObject();
                        cData.add(new CommentData(item.get("comment").getAsString(), item.get("date").getAsString())); // 왜 안되는지.

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
        //cData.add(new CommentData("맛있네요","2018/06/02"));


    }

//////////////


}




