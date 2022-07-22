package com.driskimaulana.wonderfulindonesia.model

import com.driskimaulana.wonderfulindonesia.R

object ObjectWisataData {

    private var objectWisataList = arrayListOf<ObjectWisata>(
        ObjectWisata(
            0,
            "Taman Safari Indonesia Bogor",
            "Puncak Bogor",
            "Untuk kamu yang ingin mengajak si kecil bermain sambil belajar ke tempat wisata di Bogor yang pastinya aman untuk anak-anak, kamu bisa pergi ke Taman Safari Cisarua Bogor! Di sini, kamu dan si kecil akan melihat hewan-hewan yang menakjubkan, seperti orang utan atau harimau putih dari dekat. Tak perlu khawatir, interaksimu dengan satwa liar dan langka di Taman Safari dijamin aman!",
            ticket =200000,
            rating = 5.0,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.tamansafari,
            gallery = intArrayOf(
                R.drawable.tamansafari_1,
                R.drawable.tamansafari_2,
                R.drawable.tamansafari_3,
                R.drawable.tamansafari_4,
                R.drawable.tamansafari_5,
                R.drawable.tamansafari_6
            )
        ),
        ObjectWisata(
            1,
            "Monkey Forest Ubud",
            "Gianyar, Bali",
            "Jalan-jalan ke Bali belum lengkap rasanya kalau belum ke Ubud Monkey Forest! Yup, sesuai namanya, tempat ini adalah tempat wisata outdoor yang merupakan pura sekaligus rumah bagi ribuan monyet ekor panjang Bali. Kamu bisa melihat langsung megahnya pura Hindu yang berusia ratusah tahun ini sekaligus berinteraksi langsung dengan monyet-monyet lucu yang sedang saling menyisir, melompat dari satu pohon ke yang lainnya, atau sedang makan di sini.",
            ticket =39000,
            rating = 4.5,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.monkeyforest,
            gallery = intArrayOf(
                R.drawable.monkeyforest_1,
                R.drawable.monkeyforest_2
            )
        ),
        ObjectWisata(
            2,
            "Sunrise Trekking Gunung Batur & Toya Devasya By Ubud Sunrise Hiking",
            "Bangli, Bali",
            "Bali punya banyak sekali pesona alam untuk dieksplorasi. Salah satunya adalah Gunung Batur. Selain menawarkan jalur trekking yang menantang dan menyenangkan, puncak Gunung Batur juga merupakan salah satu spot sunrise viewpoint terbaik.",
            ticket =400000,
            rating = 5.0,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.gunungbatur,
            gallery = intArrayOf(
                R.drawable.gunungbatur_1,
                R.drawable.gunungbatur_2,
                R.drawable.gunungbatur_3
            )
        ),
        ObjectWisata(
            3,
            "Toya Devasya Natural Hot Spring",
            "Bangli, Bali",
            "Jika kamu ingin berelaksasi setelah seharian mendaki dan menjelajahi pesona Bali, langsung saja ke Toya Devasya Hot Spring Wellness Resort! Fasilitas di Toya Devasya Hot Spring Waterpark termasuk tujuh kolam air panas berbeda di mana airnya dipanaskan dari dalam bumi sehingga kamu akan menyerap banyak mineral alami dan baik yang akan menyembuhkan pikiran, tubuh, dan jiwa.",
            ticket =60000,
            rating = 4.8,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.toyahotspring,
            gallery = intArrayOf(
                R.drawable.toyahotspring_1,
                R.drawable.toyahotspring_2
            )
        ),
        ObjectWisata(
            4,
            "Bali Reptile Park",
            "Gianyar, Bali",
            "Jalan-jalan ke Ubud, Bali, jangan lupa mampir ke Bali Reptile Park! Taman ini punya banyak koleksi berbagai macam reptil mulai dari komodo hingga iguana.",
            ticket = 120000,
            rating = 4.3,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.balireptile,
            gallery = intArrayOf(
                R.drawable.balireptile_1,
                R.drawable.balireptile_2
            )
        ),
        ObjectWisata(
            5,
            "Alas Harum Bali",
            "Gianyar, Bali",
            "Terletak di Tegallalang dengan luas area 6 hektar, Alas Harum Bali menyediakan banyak fasilitas aktivitas menyenangkan untuk kamu dan keluarga dengan latar belakang pemandangan sawah hijau sejauh mata memandang. Sudah terbayang betapa kerennya pemandangan di sini, kan? Belum lagi udaranya yang segar!",
            ticket = 47000,
            rating = 4.6,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.alasharum,
            gallery = intArrayOf(
                R.drawable.alasharum_1,
                R.drawable.alasharum_2
            )
        ),
        ObjectWisata(
            6,
            "Trans Studio Bandung",
            "Bandung, Jawa Barat",
            "Bandung Trans Studio bisa jadi pilihan yang tepat untuk kamu yang memiliki sejumlah wahana asyik yang cocok untuk semua usia. Berlokasi di Jalan Gatot Subroto, ini merupakan pusat perbelanjaan terbesar di Kota Bandung. Objek wisata ini dilengkapi dengan berbagai permainan yang cocok untuk si kecil hingga yang memacu adrenalin.",
            ticket = 200000,
            rating = 4.4,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.transstudio,
            gallery = intArrayOf(
                R.drawable.transstudio_1,
                R.drawable.transstudio_2,
                R.drawable.transstudio_3
            )
        ),
        ObjectWisata(
            7,
            "Lembang Park And Zoo",
            "Bandung, Jawa Barat",
            "Lembang Park Zoo adalah kebun binatang Lembang yang banyak diminati oleh wisatawan untuk menghabiskan waktu bersama keluarga. Fun fact, kebun binatang ini adalah kebun binatang terbesar di Bandung, lho!",
            ticket = 108500,
            rating = 4.6,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.lembangpark,
            gallery = intArrayOf(
                R.drawable.lembangpark_1,
                R.drawable.lembangpark_2
            )
        ),
        ObjectWisata(
            8,
            "Playtopia AEON Sentul City",
            "Bogor, Jawa Barat",
            "Taman bermain ini menyediakan berbagai wahana menarik di lokasi yang luas dan bersih untuk anak-anak. Staf Playtopia juga selalu siap sedia untuk mengawasi dan menjaga para pengunjung.",
            ticket = 145000,
            rating = 4.5,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.playtopia,
            gallery = intArrayOf(
                R.drawable.playtopia_1,
                R.drawable.playtopia_2,
                R.drawable.playtopia_3
            )
        ),
        ObjectWisata(
            9,
            "Trans Snow World Juanda Bekasi",
            "Bekasi, Jawa Barat",
            "Trans Snow World Juanda Bekasi adalah taman bermain salju indoor terbesar di Indonesia! Dibuka pada 25 Maret 2019, tempat wisata di Kota Bekasi sudah dilengkapi dengan berbagai wahana keren yang membuatmu merasa sedang menikmati hari libur di negara dengan musim dingin.",
            ticket = 200000,
            rating = 4.5,
            openSchedule = "Buka Setiap Hari",
            imageCover = R.drawable.transsnow,
            gallery = intArrayOf(
                R.drawable.transsnow_1,
                R.drawable.transsnow_2,
                R.drawable.transsnow_3
            )
        ),
    )

    val listData: ArrayList<ObjectWisata>
        get() = objectWisataList

}