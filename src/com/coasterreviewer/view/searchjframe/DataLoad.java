package com.coasterreviewer.view.searchjframe;

import com.coasterreviewer.model.services.*;
import com.coasterreviewer.model.domain.*;

import java.util.Arrays;
import java.util.List;

/**
 * This class is dedicated to loading data
 */
public class DataLoad {
	private static CoasterManufacturer rmc;
	private static CoasterManufacturer bnm;
	private static CoasterManufacturer intamin;
	private static CoasterManufacturer ss;
	private static List<Coaster> coasterList;
	private static final String DIRECTORY_NAME = "data/productionData/";

	public DataLoad() {
	}

	public static void main(String[] args) {
		try {
			rmc = new CoasterManufacturer("Rocky Mountain Construction", 1);
			bnm = new CoasterManufacturer("Bolliger & Mabillard", 2);
			intamin = new CoasterManufacturer("Intamin", 3);
			ss = new CoasterManufacturer("S&S Sansei Technologies", 4);
			Coaster c1 = new Coaster("Steel Vengeance", rmc, 2018, 1);
			c1.setDescription("This is the highlight attraction of Cedar Point in Sandusky, Ohio.");
			Coaster c2 = new Coaster("Lightning Rod", rmc, 2016, 2);
			Coaster c3 =  new Coaster("Fury 325", bnm, 2015, 3);
			c3.setDescription("This is one of very few 300+ ft tall roller coasters in the world.");
			Coaster c4 = new Coaster("Zadra", rmc, 2019, 4);
			Coaster c5 = new Coaster("El Toro", intamin, 2006, 5);
			Coaster c6 = new Coaster("Hakugei", rmc, 2019, 6);
			Coaster c7 = new Coaster("Iron Gwazi", rmc, 2022, 7);
			Coaster c8 = new Coaster("Wildfire", rmc, 2016, 8);
			Coaster c9 = new Coaster("Velocicoaster", intamin, 2021, 9);
			Coaster c10 = new Coaster("Eejanaika", ss, 2006, 10);
			Coaster[] arr = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10};
			coasterList = Arrays.asList(arr);
			ServiceFactory factory = ServiceFactory.getInstance();
			ISearchService iss = (ISearchService) factory.getService(ISearchService.NAME);
			for (Coaster c : coasterList) {
				iss.writeCoasterToFile(c, DIRECTORY_NAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
