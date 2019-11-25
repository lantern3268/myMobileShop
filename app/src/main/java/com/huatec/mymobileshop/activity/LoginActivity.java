package com.huatec.mymobileshop.activity;


import android.text.TextUtils;
import android.widget.EditText;

import com.huatec.mymobileshop.R;
import com.huatec.mymobileshop.common.BaseActivity;
import com.huatec.mymobileshop.http.ProgressDialogSubscriber;
import com.huatec.mymobileshop.http.entity.MemberEntity;
import com.huatec.mymobileshop.http.presenter.MemberPresenter;
import com.huatec.mymobileshop.utils.SystemCofig;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_username)
    EditText etUsername;

    @BindView(R.id.et_pwd)
    EditText etPwd;


    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.iv_back)
    void close(){finish();}

    @OnClick(R.id.bt_login)
    void login(){
        String userName = etUsername.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        if(TextUtils.isEmpty(userName)){
            toastshort("请输入用户名");
            return;
        }if (TextUtils.isEmpty(pwd)){
            toastshort("请输入密码");
            return;
        }

        MemberPresenter.login(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                SystemCofig.setLogin(true);
                toastshort("登陆成功");
                SystemCofig.setLoginUserName(memberEntity.uname);
                SystemCofig.setLoginUserEmail(memberEntity.email);
                SystemCofig.setLoginUserHead(memberEntity.image);
                setResult(RESULT_OK);
                finish();
            }

        },userName,pwd);
    }
}

