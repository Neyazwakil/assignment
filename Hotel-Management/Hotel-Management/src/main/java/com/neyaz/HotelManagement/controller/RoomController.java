package com.neyaz.HotelManagement.controller;

import com.neyaz.HotelManagement.model.HotelRoom;
import com.neyaz.HotelManagement.model.Type;
import com.neyaz.HotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;
    @GetMapping("rooms")
    public Iterable<HotelRoom> getAllRooms(){
        return roomService.getAllRooms();
    }


    @PostMapping("room")
    public void addRoom(@RequestBody HotelRoom hotelRoom){
        roomService.addRooms(hotelRoom);
    }



    @GetMapping("room/{id}")
    public HotelRoom getRoomById(@PathVariable Integer id){
        return roomService.getRoomById(id);
    }

    @GetMapping("room/{id}/exists")
    public boolean checkRoomExists(@PathVariable Integer id){
        return roomService.checkRoomExists(id);
    }


    @GetMapping("rooms/count")
    public Integer getTotalRooms(){
        return roomService.getTotalRooms();
    }


    @DeleteMapping("room/{id}")
    public String deleteRoomById(@PathVariable Integer id){
        return roomService.deleteRoomById(id);
    }






    @PostMapping("rooms")
    public String addRoom(@RequestBody List<HotelRoom> rooms){
        return roomService.addRoms(rooms);
    }

    // update room type on the basis of roomId
    @PutMapping("room/{id}/{type}")
    public String updateRoomById(@PathVariable Integer id,@PathVariable Type type){
        return roomService.updateRoomById(id,type);
    }


    //find rooms by status

    @GetMapping("rooms/status/{status}")
    public List<HotelRoom> getRoomsByStatus(@PathVariable Boolean status)
    {
        return roomService.getRoomsByStatus(status);
    }

    @GetMapping("rooms/status/{status}/type/{type}")
    public List<HotelRoom> getRoomsByStatusAndType(@PathVariable Boolean status,@PathVariable Type type)
    {
        return roomService.getRoomsByStatusAndType(status,type);
    }

    @GetMapping("rooms/status/{status}/type/{type}/priceRange")
    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(@PathVariable Boolean status,@PathVariable Type type, @RequestParam Double lLimit, @RequestParam Double uLimit)
    {
        return roomService.getRoomsByStatusAndTypeAndPrice(status,type,lLimit,uLimit);
    }

    @GetMapping("rooms/type/{roomType}")
    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(@PathVariable Type roomType)
    {
        return roomService.getRoomsByTypeAndPriceSortedDesc(roomType);
    }

    @GetMapping("rooms/type1/{roomType1}/type2/{roomType2}")
    public List<HotelRoom> getBudgetedAcOrNonAC(@PathVariable Type roomType1,@PathVariable Type roomType2, @RequestParam Double lLimit,@RequestParam Double uLimit)
    {
        return roomService.getBudgetedAcOrNonAC( roomType1, roomType2, lLimit,uLimit);
    }




}
