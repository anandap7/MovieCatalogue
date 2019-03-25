package com.anandap.moviecatalogue.tvshows;

import java.util.ArrayList;

class TvShowsData {
    private static String[][] data = {
            //{title, year, creator, overview, poster, cast}
            {"American Gods", "2017", "Michael Green\nBryan Fuller", "An ex-con becomes the traveling partner of a conman who turns out to be one of the older gods trying to recruit troops to battle the upstart deities. Based on Neil Gaiman's fantasy novel.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/btwTe5cQbGWGOErBiRqnjNP9cJl.jpg", "Ricky Whittle\nIan McShane\nEmily Browning\nPablo Schreiber\nBruce Langley"},

            {"Arrow", "2012", "Greg Berlanti\nMarc Guggenheim\nAndrew Kreisberg", "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg", "Stephen Amell\nEmily Bett Rickards\nDavid Ramsey\nKatie Cassidy\nEcho Kellum"},

            {"Doom Patrol", "2019", "Jeremy Carver", "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg", "Timothy Dalton\nMatt Bomer\nBrendan Fraser\nDiane Guerrero\nApril Bowlby"},

            {"Friends", "1994", "Marta Kauffman\nDavid Crane", "The misadventures of a group of friends as they navigate the pitfalls of work, life and love in Manhattan.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7buCWBTpiPrCF5Lt023dSC60rgS.jpg", "Matthew Perry\nMatt LeBlanc\nCourteney Cox\nDavid Schwimmer\nDavid Schwimmer"},

            {"Game of Thrones", "2011", "David Benioff\nD. B. Weiss", "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gwPSoYUHAKmdyVywgLpKKA4BjRr.jpg", "Emilia Clarke\nKit Harington\nPeter Dinklage\nLena Headey\nNikolaj Coster-Waldau"},

            {"Gotham", "2014", "Bruno Heller", "Before there was Batman, there was GOTHAM.\nEveryone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg", "Ben McKenzie\nDonal Logue\nDavid Mazouz\nSean Pertwee\nRobin Lord Taylor"},

            {"Grey's Anatomy", "2005", "Shonda Rhimes", "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mgOZSS2FFIGtfVeac1buBw3Cx5w.jpg", "Ellen Pompeo\nJustin Chambers\nJames Pickens Jr.\nChandra Wilson\nKevin McKidd"},

            {"Hanna", "2019", "David Farr", "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg", "Esme Creed-Miles\nJoel Kinnaman\nRhianne Barreto\nMireille Enos\nFélicien Juttner"},

            {"Lucifer", "2016", "Tom Kapinos", "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wmOuYyqVaczBLXxQNFSaRfAUgPz.jpg", "Tom Ellis\nLauren German\nKevin Alejandro\nD.B. Woodside\nLesley-Ann Brandt"},

            {"Marvel's Agents of S.H.I.E.L.D.", "2013", "Joss Whedon\nJed Whedon\nMaurissa Tancharoen", "Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wbzXfB4dWSq051hWbzQIidSvdFN.jpg", "Chloe Bennet\nClark Gregg\nMing-Na Wen\nIain De Caestecker\nElizabeth Henstridge"},

            {"NCIS", "2003", "Don McGill\nDonald P. Bellisario", "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/eoj15m14Zpf2bUWXqNIs7itZK9w.jpg", "David McCallum\nWilmer Valderrama\nEmily Wickersham\nMaria Bello\nDiona Reasonover"},

            {"Prison Break", "2005", "Paul Scheuring", "Due to a political conspiracy, an innocent man is sent to death row and his only hope is his brother, who makes it his mission to deliberately get himself sent to the same prison in order to break the both of them out, from the inside out.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5E1BhkCgjLBlqx557Z5yzcN0i88.jpg", "Wentworth Miller\nDominic Purcell\nSarah Wayne Callies\nPaul Adelstein\nRockmond Dunbar"},

            {"Revolution", "2012", "Eric Kripke", "Revolution focuses on the struggle to survive 15 years after a global blackout.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ciymUzKnlmruVIEJo8U8ywTTl0L.jpg", "Billy Burke\nTracy Spiridakos\nGiancarlo Esposito\nZak Orth\nDavid Lyons"},

            {"Riverdale", "2017", "Roberto Aguirre-Sacasa", "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gskv297rlbyzLaTU1XZf8UBbxp0.jpg", "K.J. Apa\nCamila Mendes\nLili Reinhart\nCole Sprouse\nMadelaine Petsch"},

            {"Siren", "2018", "Dean White\nEric Wald\nNick Copus", "The coastal town of Bristol Cove is known for its legend of once being home to mermaids. When the arrival of a mysterious girl proves this folklore all too true, the battle between man and sea takes a very vicious turn as these predatory beings return to reclaim their right to the ocean.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jYwhgaPwDbgC1MneMsAZTkcPcLJ.jpg", "Eline Powell\nAlex Roe\nFola Evans-Akingbola\nIan Verdun\nRena Owen"},

            {"Supergirl", "2015", "Greg Berlanti\nAndrew Kreisberg\nAli Adler", "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/vqBsgL9nd2v04ZvCqPzwtckDdFD.jpg", "Melissa Benoist\nChyler Leigh\nDavid Harewood\nMehcad Brooks\nKatie McGrath"},

            {"Supernatural", "2005", "Eric Kripke", "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3iFm6Kz7iYoFaEcj4fLyZHAmTQA.jpg", "Jensen Ackles\nJared Padalecki\nMisha Collins\nAlexander Calvert\nMark Pellegrino"},

            {"S.W.A.T.", "2017", "Aaron Rahsaan Thomas", "Follows a locally born and bred S.W.A.T. lieutenant who is torn between loyalty to the streets and duty to his fellow officers when he's tasked to run a highly-trained unit that's the last stop for solving crimes in Los Angeles.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ttzrYMdsKWR8PTRLw7uo4noqaOJ.jpg", "Shemar Moore\nStephanie Sigman\nAlex Russell\nJay Harrington\nLina Esco"},

            {"The Flash", "2014", "Geoff Johns\nAndrew Kreisberg\nGreg Berlanti", "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fki3kBlwJzFp8QohL43g9ReV455.jpg", "Grant Gustin\nCandice Patton\nCarlos Valdes\nDanielle Panabaker\nTom Cavanagh"},

            {"The Walking Dead", "2010", "Frank Darabont", "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/bjU4tLlyp8W4yTB0Hqn8J1IDUnD.jpg", "Andrew Lincoln\nNorman Reedus\nLauren Cohan\nDanai Gurira\nMelissa McBride"}
    };

    static ArrayList<TvShow> getTvShowList() {
        ArrayList<TvShow> list = new ArrayList<>();
        for (String[] data : data) {
            TvShow tvShow = new TvShow();
            tvShow.setTitle(data[0]);
            tvShow.setYear(data[1]);
            tvShow.setCreator(data[2]);
            tvShow.setOverview(data[3]);
            tvShow.setPoster(data[4]);
            tvShow.setCast(data[5]);

            list.add(tvShow);
        }
        return list;
    }
}
