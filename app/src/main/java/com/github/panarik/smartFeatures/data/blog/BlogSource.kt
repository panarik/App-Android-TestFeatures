package com.github.panarik.smartFeatures.data.blog

class BlogSource {

    companion object {

        fun createDataSet(): ArrayList<BlogPost>{
            val list = ArrayList<BlogPost>()
            list.add(
                    BlogPost(
                            "First",
                            "Body",
                            "https://raw.githubusercontent.com/panarik/SmartFeatures/master/app/src/main/res/drawable/auth250.png",
                            "Sally"
                    )
            )
            list.add(
                    BlogPost(
                            "Second",
                            "Body",
                            "https://raw.githubusercontent.com/panarik/SmartFeatures/master/app/src/main/res/drawable/auth250.png",
                            "Alex"
                    )
            )

            list.add(
                    BlogPost(
                            "Third",
                            "Body",
                            "https://raw.githubusercontent.com/panarik/SmartFeatures/master/app/src/main/res/drawable/auth250.png",
                            "John"
                    )
            )
            list.add(
                    BlogPost(
                            "One more?",
                            "Body",
                            "https://raw.githubusercontent.com/panarik/SmartFeatures/master/app/src/main/res/drawable/auth250.png",
                            "Steven"
                    )
            )
            list.add(
                    BlogPost(
                            "How about cooking?",
                            "Body",
                            "https://raw.githubusercontent.com/panarik/SmartFeatures/master/app/src/main/res/drawable/auth250.png",
                            "Richelle"
                    )
            )
            list.add(
                    BlogPost(
                            "I am steel here!",
                            "Body",
                            "https://raw.githubusercontent.com/panarik/SmartFeatures/master/app/src/main/res/drawable/auth250.png",
                            "Jessica"
                    )
            )
            return list
        }
    }


}
