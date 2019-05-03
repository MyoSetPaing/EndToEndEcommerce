package com.myosetpaing.endtoend.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.myosetpaing.endtoend.R
import com.myosetpaing.endtoend.data.model.LoginModel
import com.myosetpaing.endtoend.data.model.LoginModelImpl
import com.myosetpaing.endtoend.delegates.LoginDelegate
import com.myosetpaing.endtoend.network.response.GetLoginUserResponse
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginDelegate {
    private val mLoginModel: LoginModel

    init {
        mLoginModel = LoginModelImpl
    }
    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            mLoginModel.login("09783499931", "Abcdefg", this)
        }

    }

    override fun onSuccess(loginUser: GetLoginUserResponse) {
        startActivity(MainActivity.newIntent(this))
        finish()
    }

    override fun onFail(mag: String) {
        Toast.makeText(this, mag, Toast.LENGTH_SHORT).show()

    }

}
