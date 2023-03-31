package com.drieux.MountainPeakAPI.controller;

import com.drieux.MountainPeakAPI.model.Peak;
import com.drieux.MountainPeakAPI.repository.PeakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/peak")
public class PeakController {

    @Autowired
    private PeakRepository peakRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Peak>> getAllPeaks(){
        List<Peak> peaks = new ArrayList<>();
        peaks = peakRepository.findAll();
        if (peaks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(peaks, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Peak> createPeak(@RequestBody Peak peak){
        Peak savedPeak = this.peakRepository.save(new Peak(peak.getName(), peak.getLatitude(), peak.getLongitude(), peak.getAltitude()));
        return new ResponseEntity<>(savedPeak, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Peak> updatePeak(@PathVariable("id") long id, @RequestBody Peak peak) {
        Optional<Peak> foundPeak = peakRepository.findById(id);
        if (foundPeak.isPresent()){
            Peak peakData = foundPeak.get();
            peakData.updatePeak(peak);
            return new ResponseEntity<>(peakRepository.save(peakData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/all/range")
    public ResponseEntity<List<Peak>> getPeaksWithin(@RequestBody float la1, float lo1, float la2, float lo2){
        // The SQL request find all points between first point coordinates and second point coordinate
        if (!(isValid(la1, lo1) && isValid(la2, lo2)))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        List<Peak> foundPeaks = this.peakRepository.findByArea(la1, la2, lo1, lo2);
        return new ResponseEntity<>(foundPeaks, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePeak(@PathVariable("id") long id){
        peakRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static boolean isValid(float la, float lo){
        if (la < -90 || la > 90 ||
                lo < -180 || lo > 180) {
            return false;
        }
        return true;
    }
}
