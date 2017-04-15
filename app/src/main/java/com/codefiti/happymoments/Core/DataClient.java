package com.codefiti.happymoments.Core;

import com.codefiti.happymoments.Core.Helpers.HttpClient;
import com.codefiti.happymoments.Models.CardModel;
import com.codefiti.happymoments.Models.CompanyModel;
import com.codefiti.happymoments.Models.DeleteCardModel;
import com.codefiti.happymoments.Models.GiftcardModel;
import com.codefiti.happymoments.Models.MyGiftcardModel;
import com.codefiti.happymoments.Models.NotificationModel;
import com.codefiti.happymoments.Models.PostModel;
import com.codefiti.happymoments.Models.PostPayModel;
import com.codefiti.happymoments.Models.ReadNotificationModel;
import com.codefiti.happymoments.Models.ResultContext;
import com.codefiti.happymoments.Models.SettingsModel;
import com.codefiti.happymoments.Models.UserModel;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataClient
{
    public DataClient(String Url){
        this.Url=Url;
    }
    public HttpClient client = new HttpClient();
    public String Url = "";

    private <T> ResultContext<T> CreateErrorMessage(){
        ResultContext<T> resultContext = new ResultContext<T>();
        resultContext.setData(null);
        resultContext.setSuccess(false);
        resultContext.setMessage("İstek gönderilirken hata oluştu.");
        return resultContext;
    }

    public ResultContext<String> GetToken(final String AccessToken, final String DeviceId){
        List<NameValuePair> values = new ArrayList<NameValuePair>();
        values.add(new NameValuePair() {
            @Override
            public String getName() {
                return "grant_type";
            }

            @Override
            public String getValue() {
                return "password";
            }
        });
        values.add(new NameValuePair() {
            @Override
            public String getName() {
                return "username";
            }

            @Override
            public String getValue() {
                return DeviceId;
            }
        });
        values.add(new NameValuePair() {
            @Override
            public String getName() {
                return "password";
            }

            @Override
            public String getValue() {
                return AccessToken;
            }
        });

        JSONObject result = client.CreateNormalRequest(Url+"/api/oauth/token","POST",values);
        if(result != null)
        {
            try{
                ResultContext<String> resultContext = new ResultContext<String>();
                if(result.isNull("access_token")){
                    resultContext.setSuccess(false);
                    resultContext.setMessage(result.getString("error_description"));
                }
                else {
                    resultContext.setSuccess(true);
                    resultContext.setData(result.getString("access_token"));
                    return resultContext;
                }
            }
            catch (JSONException ex){

            }
        }
        return CreateErrorMessage();
    }

    public ResultContext<List<PostModel>> GetPosts(){
        ResultContext<List<PostModel>> resultContext = client.CreateGETRequest(Url+"/api/posts/list");
        if(resultContext!=null){
            return resultContext;
        }
        return CreateErrorMessage();
    }

    public ResultContext<List<NotificationModel>> GetNotifications(){
        ResultContext<List<NotificationModel>> resultContext = client.CreateGETRequest(Url+"/api/notificaations/list");
        if(resultContext!=null){
            return resultContext;
        }
        return CreateErrorMessage();
    }

    public ResultContext<String> ReadNotifications(int NotificationId){
        ReadNotificationModel model = new ReadNotificationModel();
        model.setNotificationId(NotificationId);
        ResultContext<String> resultContext = client.CreatePOSTRequest(Url+"/api/notifications/read",model);
        if(resultContext!=null){
            return resultContext;
        }
        return CreateErrorMessage();
    }

    public ResultContext<String> PayPost(PostPayModel model){
        ResultContext<String> resultContext = client.CreatePOSTRequest(Url+"/api/posts/pay",model);
        if(resultContext!=null){
            return resultContext;
        }
        return CreateErrorMessage();
    }

    public ResultContext<List<CardModel>> GetCardList(){
        ResultContext<List<CardModel>> resultContext = client.CreateGETRequest(Url+"/api/cards/list");
        if(resultContext!=null){
            return resultContext;
        }
        return CreateErrorMessage();
    }

    public ResultContext<String> DeleteCard(String CardId){
        DeleteCardModel model = new DeleteCardModel();
        model.setCardId(CardId);
        ResultContext<String> resultContext = client.CreatePOSTRequest(Url+"/api/cards/delete",model);
        if(resultContext!=null){
            return resultContext;
        }
        return CreateErrorMessage();
    }

    public ResultContext<UserModel> GetMe(){
        ResultContext<UserModel> resultContext = client.CreateGETRequest(Url+"/api/account/me");
        if(resultContext!=null){
            return resultContext;
        }
        return CreateErrorMessage();
    }

    public ResultContext<List<CompanyModel>> GetCompanies(){
        ResultContext<List<CompanyModel>> Companies = client.CreateGETRequest(Url+"/api/giftcards/companies");
        if(Companies!=null){
            return Companies;
        }
        return CreateErrorMessage();
    }

    public ResultContext<List<Integer>> CompanyCodes(String CompanyId){
        ResultContext<List<Integer>> resultContext = client.CreateGETRequest(Url+"/api/giftcards/companycodes?CompanyId="+CompanyId);
        if(resultContext!=null){
            return resultContext;
        }
        return CreateErrorMessage();
    }

    public ResultContext<String> BuyGiftcards(UUID CompanyId, List<Integer> Coupons) {
        GiftcardModel model = new GiftcardModel();
        model.setCompanyId(CompanyId);
        model.setCoupons(Coupons);
        ResultContext<String> req = client.CreatePOSTRequest(Url+ "/api/giftcards/buy", model);

        if (req != null)
        {
            return req;
        }
        return CreateErrorMessage();
    }

    public ResultContext<List<MyGiftcardModel>> GetMyGiftcards()
    {
        ResultContext<List<MyGiftcardModel>> req = client.CreateGETRequest(Url+"/api/giftcards/mygiftcards");

        if (req != null)
        {
            return req;
        }
        return CreateErrorMessage();
    }

    public ResultContext<String> Thanks(ReadNotificationModel model)
    {
        ResultContext<String> req = client.CreatePOSTRequest(Url+"/api/notifications/thanks", model);

        if (req != null)
        {
            return req;
        }
        return CreateErrorMessage();
    }

    public ResultContext<String> UpdateSettings(SettingsModel model)
    {
        ResultContext<String> req = client.CreatePOSTRequest(Url+"/api/account/update", model);

        if (req != null)
        {
            return req;
        }
        return CreateErrorMessage();
    }
}
