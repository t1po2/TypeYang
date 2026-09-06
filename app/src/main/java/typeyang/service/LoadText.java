package typeyang.service;

import java.util.Random;

public class LoadText {

    private final static String[] WORDS = {"apple", "beach", "chair", "dance", "eagle", "frame", "grape", "house", "image", "juice", "knife", "lemon", "mouse", "nurse", "ocean", "piano", "queen", "river", "snake", "train", "uncle", "voice", "water", "youth", "zebra", "angel", "bread", "clock", "dream", "earth", "flora", "glass", "heart", "ivory", "jewel", "koala", "light", "magic", "night", "onion", "paper", "quiet", "radio", "sugar", "tiger", "usual", "value", "whale", "xenon", "yacht", "accept", "belief", "center", "decide", "energy", "family", "garden", "happen", "island", "jacket", "kennel", "ladder", "market", "notice", "office", "public", "reason", "safety", "travel", "upward", "violent", "wander", "yellow", "zenith", "badger", "candle", "danger", "engine", "fabric", "glance", "hammer", "insect", "jungle", "kitten", "leader", "mother", "needle", "oxygen", "peanut", "rabbit", "saddle", "tablet", "umbrella", "vacuum", "walnut", "xylophone", "yogurt", "zipper", "anchor", "border", "achieve", "bargain", "capture", "damage", "earnest", "foreign", "genuine", "hygiene", "impulse", "jealous", "kingdom", "laundry", "machine", "nervous", "observe", "package", "quality", "realize", "scandal", "twilight", "unusual", "varnish", "weather", "yearning", "zealous", "absence", "bizarre", "caliber", "decline", "eclipse", "fragile", "gradual", "habitat", "idyllic", "justice", "kinetic", "logical", "musical", "nominal", "optimal", "passing", "radical", "seismic", "tactical", "utopian", "vacancy", "walking", "xylograph", "yearning", "ziggurat", "adjacent", "brilliant", "cautious", "dramatic", "emphatic", "familiar", "grateful", "hesitate", "ignorant", "judicial", "kindred", "luminous", "majestic", "negative", "obedient", "peculiar", "quaintly", "rational", "scarcely", "tranquil", "ultimate", "valuable", "wanderer", "xanthic", "youthful", "zoology", "absolute", "bountiful", "colossal", "decisive", "eloquent", "fantastic", "graceful", "harmonic", "implicit", "juvenile", "keyboard", "luxurious", "malignant", "narrative", "objective", "peaceful", "quartile", "resonant", "striking", "towering", "universal", "vanguard", "whatever", "xenogeneic", "abandon", "callback", "database", "eccentric", "feedback", "glassware", "handbook", "inkstand", "jetliner", "kelpfish", "landmark", "mainland", "network", "outpost", "postcard", "quickset", "railroad", "starfish", "teardrop", "upswing", "vanguard", "watchdog", "xenolith", "yardarm", "zookeeper", "aesthetic", "bronchitis", "camouflage", "dandelion", "eucalyptus", "fascinating", "gargantuan", "hemorrhage", "idiosyncrasy", "jurisdiction", "kaleidoscopic", "labyrinthine", "mischievous", "nomenclature", "ophthalmology", "perseverance", "questionnaire", "reconnaissance", "simultaneous", "therapeutic", "ubiquitous", "vacillating", "weathering", "xenotransplant", "zoological"} ;
    private final Random rand = new Random();


    public LoadText(){

    }

    public String getTotalText() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < WORDS.length; i++){
            int n = rand.nextInt(WORDS.length);
            sb.append(WORDS[n]);

            
            if (i+1 % 6 == 0){
                sb.append('\n');
            }

            else if (i < WORDS.length -1){
                sb.append(" ");
            }

            
        }

        return sb.toString();
    }
}