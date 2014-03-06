package com.nickelheim.activities;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nickelheim.R;
import com.nickelheim.models.Account;
import com.nickelheim.models.AccountList;
import com.nickelheim.models.AccountsPerUserList;
import com.nickelheim.models.TransactionList;
import com.nickelheim.presenters.TransactionButtonListener;
import com.nickelheim.views.TransactionActivityInterface;

public class TransactionActivity extends Activity
							implements TransactionActivityInterface {
	private TransactionButtonListener listener;
    private EditText amountField;
    private TextView balanceField;
    private AccountList accountList;
    private Account account;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transaction);
		
		listener = new TransactionButtonListener(this, this, TransactionList.getInstance());
		
        amountField =  (EditText) findViewById(R.id.amount);
        
        balanceField = (TextView) findViewById(R.id.balance);
        
        String accountName = this.getIntent().getExtras().getString(CreateAccountSuccessActivity.ACCOUNT_NAME);
        account = AccountsPerUserList.getInstance().getAccountByName(accountName);
        
        
        
        
        updateBalanceField();
        
        //String accountName = this.getIntent().getExtras().getString(CreateAccountSuccessActivity.ACCOUNT_NAME); 
        
        //account = AccountsPerUserList.getInstance().getAccountByIndex(0);
        //System.out.println(account.getAccountName());
        //System.out.println(account.getBalance());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.transaction, menu);
		return true;
	}
	
	@Override
	public double getAmount() {
        return Double.valueOf(amountField.getText().toString());
    }
	
	public Account getAccount() {
	    return account;
	}
	
	@Override
	public void attemptWithdraw(View view) {
        listener.attemptWithdraw();
    }
	
	@Override
	public void attemptDeposit(View view) {
		listener.attemptDeposit();
	}
	
	
	public void updateBalanceField() {
	    NumberFormat format = NumberFormat.getCurrencyInstance();
		balanceField.setText(format.format(account.getBalance()));	
	}

}
