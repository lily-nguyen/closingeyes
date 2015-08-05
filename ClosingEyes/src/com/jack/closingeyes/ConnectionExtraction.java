/**
*	Anthor: Huyen Kim Nguyen
*	Version 1.0
*	ConnectionExtraction handle the interaction between connection types and face information for get 
*	the right connection.
*	
*/


package com.jack.closingeyes;

import android.app.*;
import android.content.*;
import android.os.*;
import com.jack.closingeyes.connection.*;
import com.jack.closingeyes.face.*;
import com.jack.closingeyes.transfer.*;
import java.util.*;


public class ConnectionExtraction {
	
	private BaseActivity iActivity = null;
	private Connection iConnection = null;
	private FaceInformation iFace = null;
	private List<Connection> iConnections = null;
	
	
	public ConnectionExtraction (BaseActivity activity) {
		this(activity, null);
	}
	
		
	public ConnectionExtraction (BaseActivity activity, Bundle savedState) {
		iActivity = activity;
		// TODO: resume the connection
	}
	
	
	/**
	** When the FaceManagement decide that it has a new face, 
	** the ConntectionManagement has to reconnection to new device.
	** the method is called by FaceManagement
	*/
	public void faceChanged (FaceInformation face) {
		iFace = face;
		resetConnection();
	}
	
	
	public void connectionTypeChanged (List<Connection> connections) {
		iConnections = connections;
		resetConnection();
	}

	
	private Connection getTheConnection (FaceInformation face, List<Connection> connections) {
		Connection conn = null;
		// TODO: validation
		return conn;
	}
	
	private void resetConnection () {
		iConnection = null;
		if ((iFace != null) && (iConnections != null)) {
			iConnection = getTheConnection (iFace, iConnections);
		}
		if (iConnection != null) {
			// notify
			iActivity.connectionChanged(iConnection); //iActivity	
		}
	}
		
		
	public void restoreState (Bundle state) {
		// is called in activity.onRestoreInstanceState()
	}
	
	
	public void saveState (Bundle state) {
		// is called in activity.onSaveInstanceState()
	}
	
	
	public void stop () {
		// is called in activity.onStop()
	}
	

}