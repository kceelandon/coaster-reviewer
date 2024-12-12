/**
 * 
 */
/**
 * 
 */
module CoasterReviewer {
	requires junit;
	requires java.desktop;
	exports test.com.coasterreviewer.model.domain to junit;
	exports test.com.coasterreviewer.model.services to junit;
	exports test.com.coasterreviewer.model.business to junit;
}