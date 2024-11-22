package com.coasterreviewer.model.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import com.coasterreviewer.model.domain.Coaster;
import com.coasterreviewer.model.domain.CoasterReview;

public class RateServiceImpl implements IRateService {

	/**
	 * This method adds a review to a specified coaster and updates the coaster's
	 * data file at the specified directory. If no file is found in the directory,
	 * a new file will be written.
	 */
	@Override
	public void addReview(Coaster c, CoasterReview r, String directoryPath) throws IOException {
		List<CoasterReview> reviews = c.getReviews();
		reviews.add(r);
		c.setReviews(reviews);
		try {
			File f = new File(directoryPath + c.toString() + ".txt");
			FileOutputStream out;
			if (!f.isFile()) {
				out = new FileOutputStream(f);
			} else {
				out = new FileOutputStream(f, false); // false to overwrite if already exists
			}
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(c);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a List<CoasterReview> for a specified Coaster c.
	 */
	@Override
	public List<CoasterReview> getReviews(Coaster c) {
		return c.getReviews();
	}

}
