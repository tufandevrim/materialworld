/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.support.android.designlibdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class PokemonGridFragment extends Fragment {

    private static final int GRID_SPAN = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_pokemon_list, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), GRID_SPAN));
        recyclerView.setAdapter(new GridRecyclerViewAdapter(getActivity(), addFakeData()));
    }


    private List<Pokemon> addFakeData() {
        List<Pokemon> list = new ArrayList<>();
        int count = 6;
        for (int i = 0; i < 30; i++) {
            if (i % count == 0) {
                list.add(i, new Pokemon("Bulbasaur", R.drawable.bulbasaur));
            } else if (i % count == 1) {
                list.add(i, new Pokemon("Charmander", R.drawable.charmander));
            } else if (i % count == 2) {
                list.add(i, new Pokemon("Diglett", R.drawable.diglett));
            } else if (i % count == 3) {
                list.add(i, new Pokemon("Pidgey", R.drawable.pidgey));
            } else if (i % count == 4) {
                list.add(i, new Pokemon("Squirtle", R.drawable.squirtle));
            } else if (i % count == 5) {
                list.add(i, new Pokemon("Weedle", R.drawable.weedle));
            }
        }
        return list;
    }
}