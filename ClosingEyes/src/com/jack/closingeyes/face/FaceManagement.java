/**
*	Anthor: Huyen Kim Nguyen
*	Version 1.0
*	Face handle ... 
*	
*/


package com.jack.closingeyes.face;


public class FaceManagement {
	
	private ConnectionExtraction ce = null;
	private Face faceData = null;
	
	
	public FaceManagement (ConnectionExtraction cetn) {
		ce = cetn;
	}
	
	
	private void changed () {
		ce.faceChanged(faceData);
	}
	
}