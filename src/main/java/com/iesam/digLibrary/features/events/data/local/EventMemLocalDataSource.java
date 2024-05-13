package com.iesam.digLibrary.features.events.data.local;

import com.iesam.digLibrary.features.events.domain.Event;
import java.util.*;

    public class EventMemLocalDataSource  implements EventLocalDataSource {

        private static EventMemLocalDataSource instance = null;

        private EventMemLocalDataSource() {
        }

        private Map<Integer, Event> dataStore = new TreeMap<>();

        @Override
        public void save(Event model) {
            dataStore.put(model.eventId, model);
        }

        @Override
        public void saveList(List<Event> models) {
            for (Event Event : models) {
                save(Event);
            }
        }

        @Override
        public Event findById(int id) {
            return dataStore.get(id);
        }

        @Override
        public List<Event> findAll() {
            return dataStore.values().stream().toList();
        }

        @Override
        public void delete(int modelId) {
            dataStore.remove(modelId);
        }

        public static EventMemLocalDataSource getInstance() {
            if (instance == null) {
                instance = new EventMemLocalDataSource();
            }
            return instance;
        }
    }

