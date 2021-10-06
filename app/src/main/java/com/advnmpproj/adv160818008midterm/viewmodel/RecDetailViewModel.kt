package com.advnmpproj.adv160818008midterm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.advnmpproj.adv160818008midterm.model.Recipes

class RecDetailViewModel:ViewModel() {
    val recDetLD = MutableLiveData<Recipes>()

    fun LoadRecDetail()
    {
        val recDet = Recipes(3, "Hearty Meat Sauce", "Season beef with dried herbs, and simmer it low and slow with tomatoes until the flavors meld to perfection.", "Ingredients \n 2 tablespoons extra-virgin olive oil \n 1/4 teaspoon crushed red pepper flakes \n 1 small onion, chopped \n 1 carrot, finely chopped \n 3 cloves garlic, minced \n 2 tablespoons tomato paste \n Two 28-ounce cans whole peeled tomatoes, coarsely crushed \n 1 1/2 teaspoons sugar \n Kosher salt and freshly ground black pepper \n 8 ounces ground beef \n 1 teaspoon dried oregano \n 1 teaspoon dried rosemary \n 1 teaspoon dried thyme \n 1/2 cup freshly grated Parmesan, plus more for serving \n [For Serving:] Hot cooked pasta \n Directions: \n 1. Heat the oil in a medium Dutch oven or pot over medium heat. Add the red pepper flakes and stir for 15 seconds. Add the onion and carrot and cook, stirring occasionally, until the onion is golden brown, 10 to 15 minutes. Stir in the garlic and cook until soft, about 1 minute. Stir in the tomato paste and cook until brick red, about 1 minute. Add the crushed tomatoes with their juices, the sugar, 1 teaspoon of salt and a few grinds of pepper. Bring to a simmer. Partially cover the pot and continue to simmer the sauce for 15 minutes, adjusting the heat as needed to maintain a simmer. \n 2. Meanwhile, heat a large nonstick skillet over medium-high heat. Add the beef, oregano, rosemary and thyme. Sprinkle with salt and pepper. Cook the meat, breaking up with a wooden spoon, until it browns, about 5 minutes. Stir the meat into the sauce and continue to simmer, partially covered, stirring occasionally, until thickened and the flavors have blended, about 1 hour. Add a splash of water if the sauce becomes too thick. Stir the Parmesan into the sauce and adjust the seasoning with additional salt and pepper. Serve over hot pasta with extra cheese for topping.", "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2018/4/2/2/LS-Library_Hearty-Meat-Sauce_s4x3.jpg.rend.hgtvcom.616.462.suffix/1522720966329.jpeg")
        recDetLD.value = recDet
    }
}