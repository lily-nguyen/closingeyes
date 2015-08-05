/**
*	Anthor: Huyen Kim Nguyen
*	Version 1.0
*	ClosingEyes display the main screen of the application. It should only have on instance
*	
*/


package com.jack.closingeyes;

import android.view.*;
import android.view.GestureDetector.*;
import android.app.*;
import android.os.*;
import android.widget.*;
import com.jack.closingeyes.R;
import com.jack.android.util.*;
import com.jack.closingeyes.connection.*;
import com.jack.closingeyes.transfer.*;


public class ClosingEyes extends BaseActivity {
	
	private View iMainLO = null;
	private Button iContactB = null;
	private ConnectionExtraction iConnectionExtraction = null;
	private boolean iSentContact = false;
	
	private class LOGestureListener extends SimpleOnGestureListener {
		
		@Override
		public boolean onFling (MotionEvent e1, MotionEvent e2, float x, float y) {
			displayMenu();
			return true;
		}
		
	}
	
	
	public void addContact (View v) {
		ToastUtil.showText(this, "add contact method is click");
	}
	
	
	private void displayMenu () {
		iContactB.setVisibility(View.VISIBLE);
	}
	
	
	/**
	** This method is called by ConnectionExtraction to notify the status of the connection 
	*/
	protected void connectionChanged (Connection connection) {
		//TODO: this activity is not right. Should NOT create a new Transfer instance
		Transfer transfer = new Transfer();
		transfer.send(connection, Action.SENDCONTACT);
	}
	
	
	private void initial (Bundle saveState) {
		// hiding the contact button
		iContactB = (Button) findViewById (R.id.contactB); //contactB
		iContactB.setVisibility(View.INVISIBLE);
		
		// set event listener for main layout
		iMainLO = (View) findViewById(R.id.mainLO);
		setEventListener(iMainLO);	

		iConnectionExtraction = new ConnectionExtraction(this, saveState);
		iFaceManagement = new FaceManagement(iConnectionExtraction);
		iConnectionTypeManagement = new ConnectionTypeManagement(iConnectionExtraction);
		// TODO: inital ConnectionTypeManagement
	}
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		initial(savedInstanceState);
    }
	
	
	@Override
	protected void onStop () {
		super.onStop();
		iConnectionExtraction.stop();
	}
	
	
	@Override
	protected void onRestoreInstanceState (Bundle savedState) {
		iConnectionExtraction.restoreState(savedState);
	}
	
	
	@Override
	protected void onSaveInstanceState (Bundle outState) {
		iConnectionExtraction.saveState(outState);
	}
	
	
	private void setEventListener (View view) {
		final GestureDetector gestureDetector = new GestureDetector (this, new LOGestureListener());
		view.setOnTouchListener ( new View.OnTouchListener () {
			
			@Override
			public boolean onTouch (View v, MotionEvent e) {
				gestureDetector.onTouchEvent(e);
				return true;
			}
			
		});
		
	}
	
}
