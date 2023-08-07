package com.example.myapplication

import FilmListRecyclerAdapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _bindingFrag: FragmentHomeBinding? = null
    private val binding1 get() = _bindingFrag!!
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film(
            "Black Mirror",
            R.drawable.black_mirror,
            "An anthology series exploring a twisted, high-tech multiverse where humanity's greatest innovations and darkest instincts collide."
        ),
        Film(
            "The Flash",
            R.drawable.the_flash,
            "Barry Allen uses his super speed to change the past, but his attempt to save his family creates a world without super heroes, forcing him to race for his life in order to save the future."
        ),
        Film(
            "Spider-Man: Across the Spider-Verse",
            R.drawable.spider_man,
            "Miles Morales catapults across the Multiverse, where he encounters a team of Spider-People charged with protecting its very existence. When the heroes clash on how to handle a new threat, Miles must redefine what it means to be a hero."
        ),
        Film(
            "The Idol",
            R.drawable.the_idol,
            "After a nervous breakdown derailed Jocelyn's last tour, she's determined to claim her rightful status as the greatest and sexiest pop star in America. Her passions are reignited when she meets Tedros, a nightclub impresario with a sordid past. Will her romantic awakening take her to glorious new heights or the deepest, darkest depths of her soul?"
        ),
        Film(
            "Transformers: Rise of the Beasts",
            R.drawable.transformers,
            "During the '90s, a new faction of Transformers - the Maximals - join the Autobots as allies in the battle for Earth."
        ),
        Film(
            "Avatar: The Way of Water",
            R.drawable.avatar,
            "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Na'vi race to protect their home."
        ),
        Film(
            "Silo",
            R.drawable.silo,
            "Men and women live in a giant silo underground with several regulations which they believe are in place to protect them from the toxic and ruined world on the surface."
        ),
        Film(
            "Succession",
            R.drawable.succession,
            "The Roy family is known for controlling the biggest media and entertainment company in the world. However, their world changes when their father steps down from the company."
        ),
        Film(
            "The Little Mermaid",
            R.drawable.the_little_mermaid,
            "A young mermaid makes a deal with a sea witch to trade her beautiful voice for human legs so she can discover the world above water and impress a prince."
        ),
        Film(
            "Never Have I Ever",
            R.drawable.never_have_i_ever,
            "The complicated life of a first-generation Indian-American teenage girl, inspired by Mindy Kaling's own childhood."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingFrag = FragmentHomeBinding.inflate(inflater, container, false)
        return binding1.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingFrag = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //находим наш RV
        _bindingFrag?.mainRecycler?.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

}