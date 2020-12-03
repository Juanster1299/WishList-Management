package com.rest.API.Controller;

import com.rest.API.Model.WishListItems;
import com.rest.API.Repository.WishListItemsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping("/wishlistitems")
public class WishListItemsController {
	
@Autowired
private WishListItemsRepository ItemsRepository;

//GET ALL WISHLIST ITEMS
@GetMapping("/list")
private String getAllWishListItems(Model model){
 model.addAttribute("wishlistitems", ItemsRepository.findAll());
 return "WLI_list";
 
}
// From here to line 57. I create/edit my own items but i need to change it so i use the book info for the items 
@GetMapping(path = {"/add", "edit/{id}"})
private String getItemByID(@PathVariable("id") Optional<Integer> wishlistitemID, Model model){
    if(wishlistitemID.isPresent()){
		model.addAttribute("wishlistitems", ItemsRepository.findById(wishlistitemID.get()));
    }else{
        model.addAttribute("wishlistitems", new WishListItems());
    }
    return "add_edit_wishlistitems";
}

//CREATE WISHLIST Item
@PostMapping("/addEdit")
private String insertOrUpdate(WishListItems wishlistitems){
 if (wishlistitems.getWishlistitemID() == 0) {
     ItemsRepository.save(wishlistitems);
 }else{
     Optional<WishListItems> wishlistitemsOptional = ItemsRepository.findById(wishlistitems.getWishlistitemID());
     if(wishlistitemsOptional.isPresent()){
         WishListItems editWishListItems = wishlistitemsOptional.get();
         
         editWishListItems.setWishlistitemID(wishlistitems.getWishlistitemID());
         editWishListItems.setWishlist(wishlistitems.getWishlist());
         editWishListItems.setBook(wishlistitems.getBook());
         
         ItemsRepository.save(editWishListItems);
     }
 }
 return "redirect:/wishlistitems/list";
}

@GetMapping("/delete/{id}")
private String deleteWishListItem(@PathVariable("id") Integer wishlistitemID){
    Optional<WishListItems> wishlistitems = ItemsRepository.findById(wishlistitemID);
    if(wishlistitems.isPresent()){
        ItemsRepository.delete(wishlistitems.get());
    }else{
        System.err.println("not found");
    }
    //return "Wishlist_items_id";
    return "redirect:/wishlist/{id}/wishlistitems"; 
}

}