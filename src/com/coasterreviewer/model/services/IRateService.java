package com.coasterreviewer.model.services;

import java.io.IOException;
import java.util.*;
import com.coasterreviewer.model.domain.*;

public interface IRateService extends IService {
	public final String NAME = "IRateService";
	
	public void addReview(Coaster c, CoasterReview review, String dir) throws IOException;
	
	public List<CoasterReview> getReviews(Coaster c);
}
