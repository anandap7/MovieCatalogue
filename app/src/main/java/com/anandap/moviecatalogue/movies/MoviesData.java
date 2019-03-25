package com.anandap.moviecatalogue.movies;

import java.util.ArrayList;

class MoviesData {
    private static String[][] data = new String[][]{
            //{title,year,director,overview,poster,cast}
            {"A Star is Born", "2018", "Bradley Cooper", "Seasoned musician Jackson Maine discovers - and falls in love with - struggling artist Ally. She has just about given up on her dream to make it big as a singer - until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg", "Bradley Cooper\nLady Gaga\nSam Elliott\nAndrew Dice Clay\nDave Chappelle"},

            {"Alita: Battle Angel", "2019", "Robert Rodriguez", "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg", "Rosa Salazar\nChristoph Waltz\nMahershala Ali\nKeean Johnson\nJennifer Connelly"},

            {"Aquaman", "2018", "James Wan", "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg", "Jason Momoa\nAmber Heard\nWillem Dafoe\nPatrick Wilson\nNicole Kidman"},

            {"Avengers : Infinity War", "2018", "Joe Russo", "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg", "Robert Downey Jr.\nChris Hemsworth\nMark Ruffalo\nChris Evans\nScarlett Johansson"},

            {"Bohemian Rhapsody", "2018", "Bryan Singer", "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg", "Rami Malek\nGwilym Lee\nBen Hardy\nJoseph Mazzello\nLucy Boynton"},

            {"Captain Marvel", "2019", "Anna Boden", "The story follows Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg", "Brie Larson\nSamuel L. Jackson\nJude Law\nBen Mendelsohn\nAnnette Bening"},

            {"Cold Pursuit", "2019", "Hans Petter Moland", "Nels Coxman's quiet life comes crashing down when his beloved son dies under mysterious circumstances. His search for the truth soon becomes a quest for revenge as he seeks coldblooded justice against a drug lord and his inner circle.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg", "Liam Neeson\nTom Bateman\nTom Jackson\nEmmy Rossum\nLaura Dern"},

            {"Creed II", "2018", "Steven Caple Jr.", "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg", "Michael B. Jordan\nSylvester Stallone\nWood Harris\nPhylicia Rashād\nDolph Lundgren"},

            {"Fantastic Beasts: The Crimes of Grindelwald", "2018", "David Yates", "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg", "Eddie Redmayne\nKatherine Waterston\nAlison Sudol\nJohnny Depp\nJude Law"},

            {"Glass", "2019", "M. Night Shyamalan", "In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg", "James McAvoy\nBruce Willis\nSamuel L. Jackson\nAnya Taylor-Joy\nSarah Paulson"},

            {"How to Train Your Dragon : The Hidden World", "2019", "Dean DeBlois", "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg", "Jay Baruchel\nAmerica Ferrera\nF. Murray Abraham\nCate Blanchett\nGerard Butler"},

            {"Mary Queen of Scots", "2018", "Josie Rourke", "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg", "Saoirse Ronan\nMargot Robbie\nJack Lowden\nJoe Alwyn\nDavid Tennant"},

            {"Master Z: Ip Man Legacy", "2018", "Yuen Woo-ping", "After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his business, he gets into a fight with a foreigner by the name of Davidson, who is a big boss behind the bar district. Tin Chi fights hard with Wing Chun and earns respect.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/2WfjB6FUDTIBVI2y02UGbnHR82s.jpg", "Zhang Jin\nDave Bautista\nLiu Yan\nXing Yu\nMichelle Yeoh"},

            {"Mortal Engines", "2018", "Christian Rivers", "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uXJVpPXxZO4L8Rz3IG1Y8XvZJcg.jpg", "Hera Hilmar\nRobert Sheehan\nHugo Weaving\nJihae\nRonan Raftery"},

            {"Overlord", "2018", "Julius Avery", "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/l76Rgp32z2UxjULApxGXAPpYdAP.jpg", "Jovan Adepo\nWyatt Russell\nMathilde Ollivier\nPilou Asbæk\nJohn Magaro"},

            {"Ralph Breaks the Internet", "2018", "Phil Johnston", "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet -- the netizens -- to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lvfIaThG5HA8THf76nghKinjjji.jpg", "John C. Reilly\nSarah Silverman\nGal Gadot\nTaraji P. Henson\nJack McBrayer"},

            {"Robin Hood", "2018", "Otto Bathurst", "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg", "Taron Egerton\nJamie Foxx\nBen Mendelsohn\nEve Hewson\nJamie Dornan"},

            {"Serenity", "2019", "Steven Knight", "Baker Dill is a fishing boat captain leading tours off a tranquil, tropical enclave called Plymouth Island. His quiet life is shattered, however, when his ex-wife Karen tracks him down with a desperate plea for help.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg", "Matthew McConaughey\nAnne Hathaway\nDiane Lane\nJason Clarke\nDjimon Hounsou"},

            {"Spider-man : Into the Spider-verse", "2018", "Rodney Rothman", "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg", "Shameik Moore\nJake Johnson\nHailee Steinfeld\nMahershala Ali\nBrian Tyree Henry"},

            {"T-34", "2018", "Aleksey Sidorov", "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg", "Alexander Petrov\nVictor Dobronravov\nIrina Starshenbaum\nVinzenz Kiefer\nPetr Skvortsov"}
    };

    static ArrayList<Movie> getMovieList() {
        ArrayList<Movie> list = new ArrayList<>();
        for (String[] data : data) {
            Movie movie = new Movie();
            movie.setTitle(data[0]);
            movie.setYear(data[1]);
            movie.setDirector(data[2]);
            movie.setOverview(data[3]);
            movie.setPoster(data[4]);
            movie.setCast(data[5]);

            list.add(movie);
        }
        return list;
    }
}
