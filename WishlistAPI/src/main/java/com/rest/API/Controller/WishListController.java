package com.rest.API.Controller;

import com.rest.API.Model.WishList;
import com.rest.API.Model.WishListItems;
import com.rest.API.Repository.WishListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/wishlist")
public class WishListController {
	
@Autowired
private WishListRepository wishListRepository;

// GET ALL WISHLIST
@GetMapping("/list")
private String getAllWishList(Model model){
    model.addAttribute("wishlist", wishListRepository.findAll());
    return "WL_list";
}

//GET A WISHLIST
//@GetMapping("/{id}")
//private String getWishListById(@PathVariable("id")Integer wishlistid){
//	 Optional<WishList> wishlist = wishListRepository.findById(wishlistid);
// return "WL_list";
//}


@GetMapping(path = {"/add", "edit/{id}"})
private String addForm(@PathVariable("id") Optional<Integer> wishlistID, Model model){
    if(wishlistID.isPresent()){
        model.addAttribute("wishlist", wishListRepository.findById(wishlistID.get()));
    }else{
        model.addAttribute("wishlist", new WishList());
    }
    return "add_edit_wishlist";
}


// CREATE WISHLIST
@PostMapping("/addEdit")
private String insertOrUpdate(WishList wishlist){
    if (wishlist.getWishlistID() == 0) {
        wishListRepository.save(wishlist);
    }else{
        Optional<WishList> wishlistOptional = wishListRepository.findById(wishlist.getWishlistID());
        if(wishlistOptional.isPresent()){
            WishList editWishList = wishlistOptional.get();
            editWishList.setWishlistID(wishlist.getWishlistID());
            editWishList.setUserID(wishlist.getUserID());
            editWishList.setWishlistindex(wishlist.getWishlistindex());
            editWishList.setWishlistname(wishlist.getWishlistname());
            
            wishListRepository.save(editWishList);
        }
    }
    return "redirect:/wishlist/list";
}

// DELETE WISHLIST
@GetMapping("/delete/{id}")
private String deleteWishList(@PathVariable("id") Integer wishlistid){
    Optional<WishList> wishlist = wishListRepository.findById(wishlistid);
    if(wishlist.isPresent()){
        wishListRepository.delete(wishlist.get());
    }else{
        System.err.println("not found");
    }
    return "redirect:/wishlist/list";
}

//GET WISHLIST ITEMS BY WISHLIST ID
@GetMapping("/{id}/wishlistitems")
public String getItemsByWishList (@PathVariable("id") Integer wishlistID, Model model) {
    List<WishListItems> wishlistitems = (List<WishListItems>) wishListRepository.getItemsByWishList(wishlistID);
    model.addAttribute("wishlist", wishlistitems);
    return "Wishlist_items_id";
}

}

