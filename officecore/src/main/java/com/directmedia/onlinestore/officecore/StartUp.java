/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.officecore;

import com.directmedia.onlinestore.officecore.entity.Artist;
import com.directmedia.onlinestore.officecore.entity.Catalogue;
import com.directmedia.onlinestore.officecore.entity.Work;

/**
 *
 * @author adonay
 */
public class StartUp 
{
    public static void main( String[] args )
    {
    	Artist artist1 = new Artist("Datouda");
    	Artist artist2 = new Artist("SAou");
    	Artist artist = new Artist("Erico");
    	
    	Work workOne = new Work("Start up");
    	Work workSecond = new Work("Big up");
    	Work work = new Work("Do it");
        
        workOne.setMainArtist(artist1);
        workSecond.setMainArtist(artist2);
        work.setMainArtist(artist);
        
        workOne.setRelease(2020);
        workSecond.setRelease(1999);
        work.setRelease(1980);
        
        workOne.setSummary("un commencement rapide");
        workSecond.setSummary("le travail des rte");
        work.setSummary("il le faut");
        
        workOne.setGenre("fantastique");
        workSecond.setGenre("fiction");
        work.setGenre("music");
    	   
    	for (Work workOfList : Catalogue.listOfWorks) {
				
				System.out.println( workOfList.getTitle() + " ( " + workOfList.getRelease() + " )");
			
		}
    }
}